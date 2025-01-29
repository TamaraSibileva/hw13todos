package ru.netology.hw13todos.todos;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TodosTest {
    SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

    String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
    Epic epic = new Epic(55, subtasks);

    Meeting meeting = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );

    Todos todos = new Todos();

    @BeforeEach
    void setUp() {
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
    }

    @Test
    public void shouldAddThreeTasksOfDifferentType() {

        Task[] expected = { simpleTask, epic, meeting };
        Task[] actual = todos.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSimpleTask() {

        Task[] expected = { simpleTask };
        Task[] actual = (todos.search("Позвонить"));

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchEpic() {

        Task[] expected = { epic };
        Task[] actual = (todos.search("Хлеб"));

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchMeeting() {

        Task[] expected = { meeting };
        Task[] actual = (todos.search("Выкатка"));

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchFalse() {

        Task[] expected = {};
        Task[] actual = (todos.search("Вторник"));

        Assertions.assertArrayEquals(expected, actual);
    }
}
