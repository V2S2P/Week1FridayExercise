import java.time.LocalDate;
import java.util.List;

public class GardenTask extends Task{
    private String gardenLocation;

    public GardenTask(String title, String description, LocalDate dueDate) {
        super(title, description, dueDate);
    }
    public GardenTask(String title, String description, LocalDate dueDate, String gardenLocation) {
        super(title, description, dueDate);
        this.gardenLocation = gardenLocation;
    }

    public String getGardenLocation() {
        return gardenLocation;
    }

    public void setGardenLocation(String gardenLocation) {
        this.gardenLocation = gardenLocation;
    }

    @Override
    public String toString() {
        return super.toString() + " - Location " + gardenLocation;
    }
}
