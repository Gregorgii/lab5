package managers;


import java.time.LocalDate;
import java.util.Collection;

public abstract class DataManager<T> {
    public abstract DataResponse importData();
    public abstract DataResponse exportData(Collection<T> data);
    public abstract boolean recreateFile();
    public abstract LocalDate getDateInitial();
}