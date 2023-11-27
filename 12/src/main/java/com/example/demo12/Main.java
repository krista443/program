package com.example.demo12;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


interface Task {
    void execute();
}


class AtomicTask implements Task {
    private String name;

    public AtomicTask(String name) {
        this.name = name;
    }

    @Override
    public void execute() {
        System.out.println("Выполняется атомарная задача: " + name);

    }

    @Override
    public String toString() {
        return name;
    }
}


class CompositeTask implements Task {
    private String name;
    private List<Task> subTasks;

    public CompositeTask(String name) {
        this.name = name;
        this.subTasks = new ArrayList<>();
    }

    public void addSubTask(Task task) {
        subTasks.add(task);
    }

    @Override
    public void execute() {
        System.out.println("Выполняется композитная задача: " + name);
        for (Task subTask : subTasks) {
            subTask.execute();
        }
    }

    @Override
    public String toString() {
        return name;
    }
}


class TaskPanel extends JPanel {
    private DefaultListModel<Task> taskListModel;
    private JList<Task> taskList;

    public TaskPanel() {
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);

        JButton executeButton = new JButton("Выполнить");
        executeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeSelectedTask();
            }
        });

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JScrollPane(taskList));
        add(executeButton);
    }

    public void addTask(Task task) {
        taskListModel.addElement(task);
    }

    private void executeSelectedTask() {
        Task selectedTask = taskList.getSelectedValue();
        if (selectedTask != null) {
            selectedTask.execute();
        }
    }
}


public class Main {
    public static void main(String[] args) {
        CompositeTask researchProject = new CompositeTask("Исследовательский проект");

        CompositeTask experiment1 = new CompositeTask("Эксперимент 1");
        experiment1.addSubTask(new AtomicTask("Шаг 1"));
        experiment1.addSubTask(new AtomicTask("Шаг 2"));

        CompositeTask experiment2 = new CompositeTask("Эксперимент 2");
        experiment2.addSubTask(new AtomicTask("Шаг 1"));
        experiment2.addSubTask(new AtomicTask("Шаг 2"));

        researchProject.addSubTask(experiment1);
        researchProject.addSubTask(experiment2);

        TaskPanel taskPanel = new TaskPanel();
        taskPanel.addTask(researchProject);

        JFrame frame = new JFrame("Управление задачами в исследовательском проекте");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(taskPanel);
        frame.pack();
        frame.setVisible(true);
    }
}
