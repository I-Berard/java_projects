package app;

import app.models.DownloadItem;
import core.Main;
import core.MultiPartDownloader;
import core.SimpleHTTPDownloader;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ProgressBarTableCell;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DownloadManagerUI extends Application{
    private final ObservableList<DownloadItem> downloads = FXCollections.observableArrayList();

    @Override
    public void start(Stage stage){

        TextField urlField = new TextField();
        urlField.setPromptText("Enter file URL");

        Button downloadButton = new Button("Add download");

        TableView<DownloadItem> table = new TableView<>(downloads);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn<DownloadItem, String> fileNameColumn = new TableColumn<>("File name");
        fileNameColumn.setCellValueFactory(cell -> cell.getValue().fileNameProperty());

        TableColumn<DownloadItem, Double> progressColumn = new TableColumn<>("Progress");
        progressColumn.setCellValueFactory(cell -> cell.getValue().progressProperty().asObject());
        progressColumn.setCellFactory(ProgressBarTableCell.forTableColumn());

        TableColumn<DownloadItem, String> statusColumn = new TableColumn<>("Status");
        statusColumn.setCellValueFactory(cell -> cell.getValue().statusProperty());

        table.getColumns().addAll(fileNameColumn, statusColumn, progressColumn);

        downloadButton.setOnAction(e -> {
           String url = urlField.getText();
           if(url.isEmpty()) return;
           
           DownloadItem item = new DownloadItem(url);
           downloads.add(item);

           Task<Void> downloadTask = new Task<>() {
            @Override
            protected Void call() throws Exception {
                item.setStatus("Checking Server ...");
                boolean supportsMultipart = Main.sendHead(url);
                item.setStatus("Server supports Multipart: " + supportsMultipart);

                if(supportsMultipart){
                    item.setStatus("Downloading (multipart)");
                    MultiPartDownloader.downloadFile(url, item);
                }else{
                    item.setStatus("Downloading (simple)");
                    SimpleHTTPDownloader.downloadFile(url, item);
                }

                item.setProgress(1);
                item.setStatus("Completed");
                return null;
            }
           };

           new Thread(downloadTask).start();
           urlField.clear();
        });

        VBox root = new VBox(10, urlField, downloadButton, table);
        root.setStyle("-fx-padding: 20px");
        Scene scene = new Scene(root, 600, 400);
        scene.getStylesheets().add(getClass().getResource("/styles/styles.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Download Manager");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
