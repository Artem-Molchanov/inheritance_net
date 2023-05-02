package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TodosTest {

    @Test

    public void shouldAddThreeTasksOfDifferentType() {
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

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test

    public void shouldMatchSimpleTaskTitle() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean expected = true;
        boolean actual = simpleTask.matches("Позвонить родителям");
        Assertions.assertEquals(expected, actual);

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void shouldNotMatchSimpleTaskTitle() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean expected = false;
        boolean actual = simpleTask.matches("Не звонить родителям");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldMatchEpicSubtask() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};

        Epic epic = new Epic(5, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("Яйца");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldNotMatchEpicSubtask() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};

        Epic epic = new Epic(5, subtasks);

        boolean expected = false;
        boolean actual = epic.matches("Масло");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldMatchMeetingProject() {

        Meeting meeting = new Meeting(5, "Выкатка 3й версии приложения",
                "Приложение НетоБанка", "Во вторник после обеда");


        boolean expected = true;
        boolean actual = meeting.matches("Приложение НетоБанка");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldNotMatchMeetingProject() {

        Meeting meeting = new Meeting(5, "Выкатка 3й версии приложения",
                "Приложение НетоБанка", "Во вторник после обеда");


        boolean expected = false;
        boolean actual = meeting.matches("Выкатка 2й версии приложения");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldFindTodosSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        Todos todos = new Todos();
        todos.add(simpleTask);

        Task[] expected = todos.search("Позвонить родителям");
        Task[] actual = {simpleTask};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTodosEpic() {

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Todos todos = new Todos();

        todos.add(epic);

        Task[] expected = todos.search("Яйца");
        Task[] actual = {epic};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTodosMeeting() {

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        Todos todos = new Todos();

        todos.add(meeting);

        Task[] expected = todos.search("Выкатка 3й версии приложения");
        Task[] actual = {meeting};
        Assertions.assertArrayEquals(expected, actual);
    }

}
