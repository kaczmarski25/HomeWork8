package geekbrains_home_work;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Chat extends JFrame {

    public Chat() throws IOException {

        setTitle("Chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setBounds(0, 0, 500, 250);
        setLayout(new GridLayout(3,1));

        PrintWriter pw = new PrintWriter(new FileWriter("hw8.txt"));

        JTextArea textArea = new JTextArea();
        textArea.setBounds(20, 20, 80, 25);
        add(textArea);
        JTextArea textAreaMain = new JTextArea();

        add(textAreaMain);


//        Дополнительное задание на добавление полосы прокрутки в случае, если текс выходит за заданные пределы
        JScrollPane scroll = new JScrollPane(textAreaMain);
        add(scroll, textAreaMain);


        JButton button = new JButton("Отправить");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textArea.getText();
                textArea.setText(" ");
                textAreaMain.append(text + " сообщение отправлено в: " + getTime() +" \n");
                pw .append(text+ " сообщение отправлено в: " + getTime() +  ":" + " \n");
                pw.flush();
            }
        });
        add(button);
        setVisible(true);
    }
    public String getTime(){

        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }
}
