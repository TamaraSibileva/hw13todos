package ru.netology.hw13todos.todos;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TodosTest {
    SimpleTask simpleTask1 = new SimpleTask(5, "Позвонить родителям");
    SimpleTask simpleTask2 = new SimpleTask(66, "Сходить в магазин");
    SimpleTask simpleTask3 = new SimpleTask(7, "Позвонить сестре");

    String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
    Epic epic = new Epic(66, subtasks);

    Meeting meeting1 = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );
    Meeting meeting2 = new Meeting(
            666,
            "Позвонить коллеге",
            "Приложение НетоБанка",
            "В четверг вечером"
    );

    Todos todos = new Todos();

    @BeforeEach
    void setUp() {
        todos.add(simpleTask1);
        todos.add(epic);
        todos.add(meeting1);
    }

    @Test
    public void shouldAddThreeTasksOfDifferentType() {

        Task[] expected = { simpleTask1, epic, meeting1 };
        Task[] actual = todos.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSeveralTasks() {
        todos.add(simpleTask2);
        todos.add(simpleTask3);
        todos.add(meeting2);

        Task[] expected = { simpleTask1, simpleTask3, meeting2 };
        Task[] actual = todos.search("Позвонить");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchNothing() {

        Task[] expected = {};
        Task[] actual = (todos.search("вторник"));

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchOneTaskSimpleTask() {
        todos.add(simpleTask2);

        Task[] expected = { simpleTask2 };
        Task[] actual = todos.search("Магазин");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchOneTaskEpic() {

        Task[] expected = { epic };
        Task[] actual = (todos.search("ХЛЕБ"));

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchOneTaskMeeting() {

        Task[] expected = { meeting1 };
        Task[] actual = (todos.search("выкатка"));

        Assertions.assertArrayEquals(expected, actual);
    }
}
