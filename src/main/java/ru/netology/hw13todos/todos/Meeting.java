package ru.netology.hw13todos.todos;
public class Meeting extends  Task {
    protected String topic;
    protected String project;
    protected String start;

    public Meeting(int id, String topic, String project, String start) {
        super(id);
        this.topic = topic;
        this.project = project;
        this.start = start;
    }

    public String getTopic() {
        return topic;
    }

    public String getProject() {
        return project;
    }

    public String getStart() {
        return start;
    }

    @Override
    public boolean matches(String query) {
        this.topic = topic.toLowerCase();
        this.project = project.toLowerCase();
        if (topic.contains(query.toLowerCase())) {
            return true;
        }
        if (project.contains(query.toLowerCase())) {
            return true;
        }
        return false;
    }
}
