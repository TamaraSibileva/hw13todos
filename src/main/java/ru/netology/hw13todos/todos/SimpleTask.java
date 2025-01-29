package ru.netology.hw13todos.todos;
public class SimpleTask extends Task {
    protected String title;

    public SimpleTask(int id, String title) {
        super(id);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean matches(String query) {
        this.title = title.toLowerCase();
        if (title.contains(query.toLowerCase())) {
            return true;
        }
        return false;
    }
}
