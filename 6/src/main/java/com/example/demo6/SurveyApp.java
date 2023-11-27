package com.example.demo6;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


interface Question {
    String getQuestion();


    String ask();
}


class TextQuestion implements Question {
    private String question;

    TextQuestion(String question) {
        this.question = question;
    }

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public String ask() {
        return JOptionPane.showInputDialog(null, getQuestion(), "Вопрос", JOptionPane.QUESTION_MESSAGE);
    }
}


class ChoiceQuestion implements Question {
    private String question;
    private List<String> choices;

    ChoiceQuestion(String question, List<String> choices) {
        this.question = question;
        this.choices = choices;
    }

    @Override
    public String getQuestion() {
        StringBuilder stringBuilder = new StringBuilder(question + "\n");
        for (int i = 0; i < choices.size(); i++) {
            stringBuilder.append((i + 1) + ". " + choices.get(i) + "\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String ask() {
        int choice = -1;
        while (choice < 0 || choice >= choices.size()) {
            try {
                choice = Integer.parseInt(JOptionPane.showInputDialog(null, getQuestion(), "Вопрос", JOptionPane.QUESTION_MESSAGE));
            } catch (NumberFormatException e) {

            }
        }
        return choices.get(choice - 1);
    }
}


class Survey {
    private List<Question> questions = new ArrayList<>();


    void addQuestion(Question question) {
        questions.add(question);
    }


    void takeSurvey() {
        List<String> answers = new ArrayList<>();
        for (Question question : questions) {
            answers.add(question.ask());
        }
        displayResults(answers);
    }


    private void displayResults(List<String> answers) {
        StringBuilder result = new StringBuilder("Результаты анкеты:\n");
        for (int i = 0; i < questions.size(); i++) {
            result.append(questions.get(i).getQuestion()).append("\n");
            result.append("Ответ: ").append(answers.get(i)).append("\n\n");
        }
        JOptionPane.showMessageDialog(null, result.toString(), "Результаты анкеты", JOptionPane.INFORMATION_MESSAGE);
    }
}


public class SurveyApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Survey App");
            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JButton startButton = new JButton("Start Survey");
            startButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    Survey survey = new Survey();
                    survey.addQuestion(new TextQuestion("Как вас зовут?"));
                    survey.addQuestion(new ChoiceQuestion("Какой ваш любимый цвет?", List.of("Красный", "Зеленый", "Синий")));
                    survey.addQuestion(new TextQuestion("Сколько вам лет?"));
                    survey.addQuestion(new ChoiceQuestion("Что вы предпочитаете: кофе или чай?", List.of("Кофе", "Чай")));
                    survey.addQuestion(new TextQuestion("Какие хобби у вас есть?"));


                    survey.takeSurvey();
                }
            });

            JPanel panel = new JPanel();
            panel.add(startButton);
            frame.add(panel);

            frame.setVisible(true);
        });
    }
}
