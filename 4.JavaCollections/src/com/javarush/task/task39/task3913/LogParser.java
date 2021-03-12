package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.*;
import com.javarush.task.task39.task3913.util.LogVisitor;
import com.javarush.task.task39.task3913.util.MyParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery {
    private final Path logDir;

    public LogParser(Path logDir) {
        this.logDir = logDir;
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return getUniqueIPs(after, before).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        Set<String> uniqueIPs = new HashSet<>();
        getLogs(after, before).forEach(e-> uniqueIPs.add(e.getIp()));
        return uniqueIPs;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        Set<String> ipsForUser = new HashSet<>();
        for (Log log : getLogs(after, before)) {
            if (log.getUser().equals(user)) {
                ipsForUser.add(log.getIp());
            }
        }
        return ipsForUser;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        Set<String> ipsForEvent = new HashSet<>();
        for (Log log : getLogs(after, before)) {
            if (log.getEvent().equals(event)) {
                ipsForEvent.add(log.getIp());
            }
        }
        return ipsForEvent;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        Set<String> ipsForStatus = new HashSet<>();
        for (Log log : getLogs(after, before)) {
            if (log.getStatus().equals(status)) {
                ipsForStatus.add(log.getIp());
            }
        }
        return ipsForStatus;
    }

    @Override
    public Set<String> getAllUsers() {
        Set<String> result = new HashSet<>();
        getLogs(null, null).forEach(e-> result.add(e.getUser()));
        return result;
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {
        Set<String> result = new HashSet<>();
        getLogs(after, before).forEach(e-> result.add(e.getUser()));
        return result.size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        Set<Event> result = new HashSet<>();
        getLogs(after, before).forEach(e-> {
            if (e.getUser().equals(user)) {
                result.add(e.getEvent());
            }
        });
        return result.size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        Set<String> result = new HashSet<>();
        getLogs(after, before).forEach(e-> {
            if (e.getIp().equals(ip)) {
                result.add(e.getUser());
            }
        });
        return result;
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        Set<String> result = new HashSet<>();
        getLogs(after, before).forEach(e-> {
            if (e.getEvent().equals(Event.LOGIN)) {
                result.add(e.getUser());
            }
        });
        return result;
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        Set<String> result = new HashSet<>();
        getLogs(after, before).forEach(e-> {
            if (e.getEvent().equals(Event.DOWNLOAD_PLUGIN)) {
                result.add(e.getUser());
            }
        });
        return result;
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        Set<String> result = new HashSet<>();
        getLogs(after, before).forEach(e-> {
            if (e.getEvent().equals(Event.WRITE_MESSAGE)) {
                result.add(e.getUser());
            }
        });
        return result;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        Set<String> result = new HashSet<>();
        getLogs(after, before).forEach(e-> {
            if (e.getEvent().equals(Event.SOLVE_TASK)) {
                result.add(e.getUser());
            }
        });
        return result;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        Set<String> result = new HashSet<>();
        getLogs(after, before).forEach(e-> {
            if (e.getEvent().equals(Event.SOLVE_TASK) && e.getTask()==task) {
                result.add(e.getUser());
            }
        });
        return result;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        Set<String> result = new HashSet<>();
        getLogs(after, before).forEach(e-> {
            if (e.getEvent().equals(Event.DONE_TASK)) {
                result.add(e.getUser());
            }
        });
        return result;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        Set<String> result = new HashSet<>();
        getLogs(after, before).forEach(e-> {
            if (e.getEvent().equals(Event.DONE_TASK) && e.getTask() == task) {
                result.add(e.getUser());
            }
        });
        return result;
    }

    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        Set<Date> result = new HashSet<>();
        getLogs(after, before).forEach(e-> {
            if (e.getUser().equals(user) && e.getEvent().equals(event)) {
                result.add(e.getDate());
            }
        });
        return result;
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        Set<Date> result = new HashSet<>();
        getLogs(after, before).forEach(e-> {
            if (e.getStatus().equals(Status.FAILED)) {
                result.add(e.getDate());
            }
        });
        return result;
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        Set<Date> result = new HashSet<>();
        getLogs(after, before).forEach(e-> {
            if (e.getStatus().equals(Status.ERROR)) {
                result.add(e.getDate());
            }
        });
        return result;
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        Set<Date> result = new HashSet<>();
        getLogs(after, before).forEach(e-> {
            if (e.getEvent().equals(Event.LOGIN) && e.getUser().equals(user)) {
                result.add(e.getDate());
            }
        });
        if (result.size()!=0) {
            return Collections.min(result);
        }
        return null;
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        Set<Date> result = new HashSet<>();
        getLogs(after, before).forEach(e-> {
            if (e.getEvent().equals(Event.SOLVE_TASK) && e.getTask() == task && e.getUser().equals(user)) {
                result.add(e.getDate());
            }
        });
        if (result.size()!=0) {
            return Collections.min(result);
        }
        return null;
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        Set<Date> result = new HashSet<>();
        getLogs(after, before).forEach(e-> {
            if (e.getEvent().equals(Event.DONE_TASK) && e.getTask() == task && e.getUser().equals(user)) {
                result.add(e.getDate());
            }
        });
        if (result.size()!=0) {
            return Collections.min(result);
        }
        return null;
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        Set<Date> result = new HashSet<>();
        getLogs(after, before).forEach(e-> {
            if (e.getEvent().equals(Event.WRITE_MESSAGE) && e.getUser().equals(user)) {
                result.add(e.getDate());
            }
        });
        return result;
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        Set<Date> result = new HashSet<>();
        getLogs(after, before).forEach(e-> {
            if (e.getEvent().equals(Event.DOWNLOAD_PLUGIN) && e.getUser().equals(user)) {
                result.add(e.getDate());
            }
        });
        return result;
    }

    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        return getAllEvents(after, before).size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        Set<Event> result = new HashSet<>();
        getLogs(after, before).forEach(e-> result.add(e.getEvent()));
        return result;
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        Set<Event> result = new HashSet<>();
        getLogs(after, before).forEach(e-> {
            if (e.getIp().equals(ip)) {
                result.add(e.getEvent());
            }
        });
        return result;
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        Set<Event> result = new HashSet<>();
        getLogs(after, before).forEach(e-> {
            if (e.getUser().equals(user)) {
                result.add(e.getEvent());
            }
        });
        return result;
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        Set<Event> result = new HashSet<>();
        getLogs(after, before).forEach(e-> {
            if (e.getStatus().equals(Status.FAILED)) {
                result.add(e.getEvent());
            }
        });
        return result;
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        Set<Event> result = new HashSet<>();
        getLogs(after, before).forEach(e-> {
            if (e.getStatus().equals(Status.ERROR)) {
                result.add(e.getEvent());
            }
        });
        return result;
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        int result = 0;
        for (Log e : getLogs(after, before)) {
            if (e.getEvent().equals(Event.SOLVE_TASK) && e.getTask() == task) {
                result++;
            }
        }
        return result;
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        int result = 0;
        for (Log e : getLogs(after, before)) {
            if (e.getEvent().equals(Event.DONE_TASK) &&
                    e.getTask() == task
            ) {
                result++;
            }
        }
        return result;
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        Map<Integer, Integer> result = new HashMap<>();
        for (Log e : getLogs(after, before)) {
            if (e.getEvent().equals(Event.SOLVE_TASK) &&
                    !result.containsKey(e.getTask())
            ) {
                result.put(e.getTask(), getNumberOfAttemptToSolveTask(e.getTask(), after, before));
            }
        }
        return result;
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        Map<Integer, Integer> result = new HashMap<>();
        for (Log e : getLogs(after, before)) {
            if (e.getEvent().equals(Event.DONE_TASK) &&
                    !result.containsKey(e.getTask())
            ) {
                result.put(e.getTask(), getNumberOfSuccessfulAttemptToSolveTask(e.getTask(), after, before));
            }
        }
        return result;
    }

    @Override
    public Set<Object> execute(String query) {

        if (query.split(" ").length == 2) {
            return  executeShortQuery(query);
        }

        if (query.contains("and date between")) {
            String[] request = MyParser.getLongQueryArray(query);
            Date after = MyParser.getDate(request[3]);
            Date before = MyParser.getDate(request[4]);
            return executeLongQuery(request, after, before);
        }

        String[] request = MyParser.getMediumQueryArray(query);
        return executeLongQuery(request, null, null);
    }

    private List<Log> getLogs(Date after, Date before) {
        LogVisitor visitor = new LogVisitor(after, before);
        try {
            Files.walkFileTree(logDir, visitor);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return visitor.getLogs();
    }

    private Set<Object> executeShortQuery(String query) {
        Set<Object> result = new HashSet<>();

        switch (query) {
            case "get ip":
                result = new HashSet<>(getUniqueIPs(null, null));
                break;
            case "get user":
                result = new HashSet<>(getAllUsers());
                break;
            case "get date":
                result = new HashSet<>();
                for (Log e : getLogs(null, null)) {
                    result.add(e.getDate());
                }
                break;
            case "get event":
                result = new HashSet<>(getAllEvents(null, null));
                break;
            default: {
                for (Log e : getLogs(null, null)) {
                    result.add(e.getStatus());
                }
            }
        }

        return result;
    }
    private Set<Object> executeLongQuery(String[] query, Date after, Date before) {
        Set<Object> result = new HashSet<>();

        if (query[0].equals("ip")) {
            switch (query[1]) {
                case "user" :
                    result = new HashSet<>(getIPsForUser(query[2], after, before));
                    break;
                case "date" :
                    Date date = MyParser.getDate(query[2]);
                    for (Log log : getLogs(after, before)) {
                        if (log.getDate().equals(date)) {
                            result.add(log.getIp());
                        }
                    }
                    break;
                case "event" :
                    result = new HashSet<>(getIPsForEvent(MyParser.getEvent(query[2]), after, before));
                    break;
                case "status" :
                    result = new HashSet<>(getIPsForStatus(MyParser.getStatus(query[2]), after, before));
                    break;
            }
        }

        if (query[0].equals("user")) {
            switch (query[1]) {
                case "ip" :
                    result = new HashSet<>(getUsersForIP(query[2], after, before));
                    break;
                case "date" :
                    Date date = MyParser.getDate(query[2]);
                    for (Log log : getLogs(after, before)) {
                        if (log.getDate().equals(date)) {
                            result.add(log.getUser());
                        }
                    }
                    break;
                case "event" :
                    Event event = MyParser.getEvent(query[2]);
                    for (Log log : getLogs(after, before)) {
                        if (log.getEvent().equals(event)) {
                            result.add(log.getUser());
                        }
                    }
                    break;
                case "status" :
                    Status status = MyParser.getStatus(query[2]);
                    for (Log log : getLogs(after, before)) {
                        if (log.getStatus().equals(status)) {
                            result.add(log.getUser());
                        }
                    }
                    break;
            }
        }

        if (query[0].equals("date")) {
            switch (query[1]) {
                case "ip" :
                    for (Log log : getLogs(after, before)) {
                        if (log.getIp().equals(query[2])) {
                            result.add(log.getDate());
                        }
                    }
                    break;
                case "user" :
                    for (Log log : getLogs(after, before)) {
                        if (log.getUser().equals(query[2])) {
                            result.add(log.getDate());
                        }
                    }
                    break;
                case "event" :
                    Event event = MyParser.getEvent(query[2]);
                    for (Log log : getLogs(after, before)) {
                        if (log.getEvent().equals(event)) {
                            result.add(log.getDate());
                        }
                    }
                    break;
                case "status" :
                    Status status = MyParser.getStatus(query[2]);
                    for (Log log : getLogs(after, before)) {
                        if (log.getStatus().equals(status)) {
                            result.add(log.getDate());
                        }
                    }
                    break;
            }
        }

        if (query[0].equals("event")) {
            switch (query[1]) {
                case "ip" :
                    result = new HashSet<>(getEventsForIP(query[2], after, before));
                    break;
                case "user" :
                    result = new HashSet<>(getEventsForUser(query[2], after, before));
                    break;
                case "date" :
                    Date date = MyParser.getDate(query[2]);
                    for (Log log : getLogs(after, before)) {
                        if (log.getDate().equals(date)) {
                            result.add(log.getEvent());
                        }
                    }
                    break;
                case "status" :
                    Status status = MyParser.getStatus(query[2]);
                    for (Log log : getLogs(after, before)) {
                        if (log.getStatus().equals(status)) {
                            result.add(log.getEvent());
                        }
                    }
                    break;
            }
        }

        if (query[0].equals("status")) {
            switch (query[1]) {
                case "ip" :
                    for (Log log : getLogs(after, before)) {
                        if (log.getIp().equals(query[2])) {
                            result.add(log.getStatus());
                        }
                    }
                    break;
                case "user" :
                    for (Log log : getLogs(after, before)) {
                        if (log.getUser().equals(query[2])) {
                            result.add(log.getStatus());
                        }
                    }
                    break;
                case "event" :
                    Event event = MyParser.getEvent(query[2]);
                    for (Log log : getLogs(after, before)) {
                        if (log.getEvent().equals(event)) {
                            result.add(log.getStatus());
                        }
                    }
                    break;
                case "date" :
                    Date date = MyParser.getDate(query[2]);
                    for (Log log : getLogs(after, before)) {
                        if (log.getDate().equals(date)) {
                            result.add(log.getStatus());
                        }
                    }
                    break;
            }
        }

        return result;
    }
}