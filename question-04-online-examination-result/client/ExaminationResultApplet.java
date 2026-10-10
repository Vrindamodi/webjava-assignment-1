import java.applet.Applet;
import java.awt.Button;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

public class ExaminationResultApplet extends Applet implements ActionListener {

    TextField roll = new TextField(8);
    TextField sub1 = new TextField(5);
    TextField sub2 = new TextField(5);
    TextField sub3 = new TextField(5);
    Button submit = new Button("Get Result");
    Label result = new Label("Result will appear here");

    public void init() {
        add(new Label("Roll:"));
        add(roll);
        add(new Label("Marks 1:"));
        add(sub1);
        add(new Label("Marks 2:"));
        add(sub2);
        add(new Label("Marks 3:"));
        add(sub3);
        add(submit);
        add(result);

        submit.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            // parameters sent to the servlet
            String data = "rollNumber=" + roll.getText() + "&subject1=" + sub1.getText()
                    + "&subject2=" + sub2.getText() + "&subject3=" + sub3.getText();

            URL url = new URL(getCodeBase(), "exam-result");
            URLConnection con = url.openConnection();
            con.setDoOutput(true);

            OutputStreamWriter out = new OutputStreamWriter(con.getOutputStream());
            out.write(data);
            out.close();

            // show the result returned by the servlet
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            result.setText(in.readLine());
            in.close();
        } catch (Exception ex) {
            result.setText("Error: " + ex.getMessage());
        }
    }
}
