/*Veri girişlerinde hatalı girişler exception handling yapısı ile kontrol edilmelidir.*/
package com.example.java__project;

import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystemLoopException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.*;

public class Controller extends abs implements Initializable,inter{

    Image image=new Image("file:\\C:\\Users\\Dell\\IdeaProjects\\JAVA__PROJECT\\src\\main\\resources\\com\\example\\java__project\\payroll.jpg");
    public ImageView imageView=new ImageView(image);

    Image srch=new Image("file:\\C:\\Users\\Dell\\IdeaProjects\\JAVA__PROJECT\\src\\main\\resources\\com\\example\\java__project\\searchbutton.png");
    public ImageView srchview=new ImageView(srch);

    Image add=new Image("file:\\C:\\Users\\Dell\\IdeaProjects\\JAVA__PROJECT\\src\\main\\resources\\com\\example\\java__project\\addperson.jpg");
    public ImageView addview=new ImageView(add);

    Image list=new Image("file:\\C:\\Users\\Dell\\IdeaProjects\\JAVA__PROJECT\\src\\main\\resources\\com\\example\\java__project\\liste.jpg");
    public ImageView listview=new ImageView(list);

    @FXML
 private TextField username;
    @FXML
 public PasswordField password;
    @FXML
    private Label giris;
    @FXML
    private TextField name;
    public TextField surname,id,gender,date,salary,department,search;
    public TextField surname1,id1,gender1,date1,salary1,department1,name1;
    public TextField overtime,medical,bonus,rateperhour,other,totalamount;
private Stage stage;
private Scene scene;
public int temp=0;


ArrayList<String> list2=new ArrayList<>();
ArrayList<String> list3=new ArrayList<>();
ArrayList<String> list4=new ArrayList<>();
ArrayList<String> list5=new ArrayList<>();
ArrayList<String > list6=new ArrayList<>();


    public void login(ActionEvent event) throws IOException {

        if (Objects.equals(this.username.getText(), "Manager") && Objects.equals(this.password.getText(), "admin123")){
            this.giris.getText();this.giris.setText("Successful Log In");
            Parent root=FXMLLoader.load(Objects.requireNonNull(getClass().getResource("searchoradd.fxml")));
            stage= (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
        else
        {
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setTitle("");
            alert.setResizable(false);
            alert.getDialogPane().setPrefSize(250,50);
            alert.setHeaderText("Incorrect password or username!");
            alert.show();
        }


    }
    public void tosearch(ActionEvent event) throws IOException {

        Parent root=FXMLLoader.load(Objects.requireNonNull(getClass().getResource("search.fxml")));
        stage= (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void toadd(ActionEvent event) throws IOException {

        Parent root=FXMLLoader.load(Objects.requireNonNull(getClass().getResource("add.fxml")));
        stage= (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void tolist(ActionEvent event) throws IOException{
        Parent root=FXMLLoader.load(Objects.requireNonNull(getClass().getResource("list.fxml")));
        stage= (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    public void back1(ActionEvent event) throws IOException {

        Parent root=FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main.fxml")));
        stage= (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void back2(ActionEvent event) throws IOException {

        Parent root=FXMLLoader.load(Objects.requireNonNull(getClass().getResource("searchoradd.fxml")));
        stage= (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void add(ActionEvent event) throws IOException {

        File fileee=new File("C:\\Users\\Dell\\Documents\\JAVA\\JAVA__PROJECT\\src\\main\\java\\com\\example\\java__project\\employeeinfo.txt");

        Scanner inputtt=new Scanner(fileee);

        inputtt.useDelimiter(";");

        while (inputtt.hasNext()) {
            String worddd  = inputtt.next();
            list6.add(worddd);

        }
if(!this.id.getText().equals("") && !this.name.getText().equals("") && !this.surname.getText().equals("")
        && !this.gender.getText().equals("") && !this.date.getText().equals("")
        && !this.department.getText().equals("") && !this.salary.getText().equals("") ){
    if((!list6.contains(this.id.getText())))
    {
        FileOutputStream  file= new FileOutputStream("C:\\Users\\Dell\\Documents\\JAVA\\JAVA__PROJECT\\src\\main\\java\\com\\example\\java__project\\employeeinfo.txt",true);
        employee employeee = new employee(Integer.parseInt(this.id.getText()), this.name.getText(), this.surname.getText(),
                this.gender.getText(), this.date.getText(), Integer.parseInt(this.salary.getText()), this.department.getText());
        File file2 = new File("C:\\Users\\Dell\\Documents\\JAVA\\JAVA__PROJECT\\src\\main\\java\\com\\example\\java__project\\amounts.txt");
        FileWriter input = new FileWriter(file2, true);
        input.write("Any amount is not added yet..." + ";");
        input.close();
        File file3 = new File("C:\\Users\\Dell\\Documents\\JAVA\\JAVA__PROJECT\\src\\main\\java\\com\\example\\java__project\\dates.txt");
        FileWriter input2 = new FileWriter(file3, true);
        Date date=new Date();
        input2.write("Date of employement:" +date.toString()+ ";");
        input2.close();
        infoadd(file, employeee);
        Info(event);
    } else {
        Alert alert=new Alert(Alert.AlertType.ERROR);
        alert.setTitle("");
        alert.setHeaderText("Entered ID is not available");
        alert.show();
    }

}else {

    Alert alert=new Alert(Alert.AlertType.ERROR);
    alert.setTitle("");
    alert.setHeaderText("Any field cannot be left blank!");
    alert.show();
}
}



    @FXML
    public  void searchf() throws FileNotFoundException {
        File file=new File("C:\\Users\\Dell\\Documents\\JAVA\\JAVA__PROJECT\\src\\main\\java\\com\\example\\java__project\\employeeinfo.txt");
        Scanner input=new Scanner(file);
        input.useDelimiter(";");
        while (input.hasNext()) {
            String word  = input.next();
            list2.add(word);

        }
        for(int i=0;i<list2.size()/7;i++)
        {
            if((search.getText()).equals(list2.get(i*7)))
            {
                this.id1.setText(list2.get(i*7));
                this.name1.setText(list2.get(i*7+1));
                this.surname1.setText(list2.get(i*7+2));
                this.gender1.setText(list2.get(i*7+3));
                this.date1.setText(list2.get(i*7+4));
                this.department1.setText(list2.get(i*7+5));
                this.salary1.setText(list2.get(i*7+6));
                temp++;
            }
            else  if (search.getText().equals(""))
            {
                this.id1.setText("");
                this.name1.setText("");
                this.surname1.setText("");
                this.gender1.setText("");
                this.date1.setText("");
                this.department1.setText("");
                this.salary1.setText("");
            }

        }if(temp==0)
        {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Entered ID is not found!");
            alert.setTitle("");
            alert.show();
        }



    }

    @Override
    public void infoadd(FileOutputStream file, employee e) {
        PrintWriter input = new PrintWriter(file);
        input.write(e.getId1()+";"+e.getName1()+";"+e.getSurname1()+";"+e.getGender1()+";"+e.getDate1()+";"+e.getDepartment1()+";"+e.getSalary1()+";");
        input.close();
    }



    @Override
    public void calculate() {

        if(!this.overtime.getText().equals("") && !this.medical.getText().equals("") && !this.bonus.getText().equals("") && !this.other.getText().equals("") && !this.rateperhour.getText().equals(""))
this.totalamount.setText(String.valueOf(Integer.parseInt(this.medical.getText())*0.85+Integer.parseInt(this.bonus.getText())*0.96+Integer.parseInt(this.other.getText())+Integer.parseInt(this.overtime.getText())*Integer.parseInt(this.rateperhour.getText())));
   else {

       Alert alert=new Alert(Alert.AlertType.ERROR);
       alert.setTitle("");
       alert.setHeaderText("Any field cannot be left blank!");
       alert.show();
        } }

    @Override
    public void save(ActionEvent event)  {
        if(!this.search.getText().equals("")){
            if(!this.totalamount.getText().equals(""))
            {
                try (Writer writer = Files.newBufferedWriter(
                        Paths.get("C:\\Users\\Dell\\Documents\\JAVA\\JAVA__PROJECT\\src\\main\\java\\com\\example\\java__project\\amounts.txt"), StandardCharsets.UTF_8,
                        StandardOpenOption.WRITE,
                        StandardOpenOption.APPEND)) {
                    writer.write(this.totalamount.getText()+";");}
                catch (IOException ioException)
                {
                    System.out.println("File is not found!");
                }
                try(
                        Writer writer2 = Files.newBufferedWriter(
                                Paths.get("C:\\Users\\Dell\\Documents\\JAVA\\JAVA__PROJECT\\src\\main\\java\\com\\example\\java__project\\dates.txt"), StandardCharsets.UTF_8,
                                StandardOpenOption.WRITE,
                                StandardOpenOption.APPEND)) {
                    Date date=new Date();
                    writer2.write("Amount was added in:"+date.toString()+";");

                }
                catch (IOException ioException)
                {
                    System.out.println("File is not found!");
                }
                try(
                        Writer writer3 = Files.newBufferedWriter(
                                Paths.get("C:\\Users\\Dell\\Documents\\JAVA\\JAVA__PROJECT\\src\\main\\java\\com\\example\\java__project\\employeeinfo.txt"), StandardCharsets.UTF_8,
                                StandardOpenOption.WRITE,
                                StandardOpenOption.APPEND)) {
                    writer3.write(this.id1.getText()+";"+this.name1.getText()+";"+this.surname1.getText()+";"+this.gender1.getText()+";"+this.date1.getText()+";"+this.department1.getText()+";"+this.salary1.getText()+";");

                }
                catch (IOException ioException)
                {
                    System.out.println("File is not found");
                }
                Info(event);
            }
            else {
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setTitle("");
                alert.setHeaderText("Total amount is not available");
                alert.show();
            }
        }
        else{
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("");
            alert.setHeaderText("Enter any ID please");
            alert.show();
        }


    }
    @FXML
    private void Info(ActionEvent event)
    {
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info");
        alert.setHeaderText("Data is saved succesfully!");
        alert.show();

    }


    @FXML
    ListView<String> listView1=new ListView<>();
    @FXML
    ListView<String> listView2=new ListView<>();
    @FXML
    ListView<String> listView3=new ListView<>();
    @FXML
    ListView<String> listView4=new ListView<>();
    @FXML
    ListView<String> listView5=new ListView<>();


@FXML
private void show() throws FileNotFoundException {

    File file=new File("C:\\Users\\Dell\\Documents\\JAVA\\JAVA__PROJECT\\src\\main\\java\\com\\example\\java__project\\employeeinfo.txt");

    Scanner input=new Scanner(file);

    input.useDelimiter(";");

    while (input.hasNext()) {
        String word  = input.next();
        list3.add(word);

    }
    for(int i=0;i<list3.size()/7;i++)
    {
        listView1.getItems().add(list3.get(i*7));
        listView2.getItems().add(list3.get(i*7+1));
        listView3.getItems().add(list3.get(i*7+2));

    }
    showdetails(listView5);
    showdetails(list4);

}
@FXML
    private void showdetails(ListView<String> stringListView) throws FileNotFoundException {
    File file2=new File("C:\\Users\\Dell\\Documents\\JAVA\\JAVA__PROJECT\\src\\main\\java\\com\\example\\java__project\\amounts.txt");
      Scanner input2=new Scanner(file2);
      input2.useDelimiter(";");
    while (input2.hasNext()) {
        String word2  = input2.next();
        list5.add(word2);

    }
        for (int i=0;i<list5.size();i++)
        {
            listView5.getItems().add(list5.get(i));
        }


    }
@FXML
private  void showdetails(ArrayList<String> list4) throws FileNotFoundException {
    File file3=new File("C:\\Users\\Dell\\Documents\\JAVA\\JAVA__PROJECT\\src\\main\\java\\com\\example\\java__project\\dates.txt");
    Scanner input3=new Scanner(file3);
    input3.useDelimiter(";");
    while (input3.hasNext()) {
        String word3  = input3.next();
        list4.add(word3);

    }
    for (int i=0;i<list4.size();i++)
    {
        listView4.getItems().add(list4.get(i));
    }

}

    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void info2()
    {
        Alert alert =new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("");
        alert.setHeaderText("Medical*0.85\nBonus*0.96\nOther\nTotal Overtime*Rate per hour");
        alert.show();

    }



}
