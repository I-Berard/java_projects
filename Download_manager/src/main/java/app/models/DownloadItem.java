package app.models;
import javafx.beans.property.*;

public class DownloadItem {
    private final StringProperty fileName = new SimpleStringProperty();
    private final DoubleProperty progress = new SimpleDoubleProperty();
    private final StringProperty status = new SimpleStringProperty();

    public DownloadItem(String filename){
        this.fileName.set(filename);
        this.progress.set(0);
        this.status.set("Pending");
    }

    public StringProperty fileNameProperty(){
        return fileName;
    }
    
    public DoubleProperty progressProperty(){
        return progress;
    }

    public StringProperty statusProperty(){
        return status;
    }

    public void setFileName(String fileName){
        this.fileName.set(fileName);
    }

    public void setProgress(double progress){
        this.progress.set(progress);
    }

    public void setStatus(String status){
        this.status.set(status);
    }

	public StringProperty getFileName() {
		return fileName;
	}

	public DoubleProperty getProgress() {
		return progress;
	}

	public StringProperty getStatus() {
		return status;
	}

    
}
