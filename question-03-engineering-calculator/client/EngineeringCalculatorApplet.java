import java.applet.Applet;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

public class EngineeringCalculatorApplet extends Applet implements ActionListener {

    TextField number1 = new TextField(8);
    TextField number2 = new TextField(8);
    Choice operation = new Choice();
    Button calculate = new Button("Calculate");
    Label result = new Label("Result will appear here");

    public void init() {
        operation.add("add");
        operation.add("subtract");
        operation.add("multiply");
        operation.add("divide");

        add(new Label("Number 1:"));
        add(number1);
        add(new Label("Number 2:"));
        add(number2);
        add(operation);
        add(calculate);
        add(result);

        calculate.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            // data sent to the servlet
            String data = "number1=" + number1.getText() + "&number2=" + number2.getText()
                    + "&operation=" + operation.getSelectedItem();

            // connect to the servlet
            URL url = new URL(getCodeBase(), "calculate");
            URLConnection con = url.openConnection();
            con.setDoOutput(true);

            OutputStreamWriter out = new OutputStreamWriter(con.getOutputStream());
            out.write(data);
            out.close();

            // read the answer from the servlet
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            result.setText(in.readLine());
            in.close();
        } catch (Exception ex) {
            result.setText("Error: " + ex.getMessage());
        }
    }
}
