package geography;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

public class ProvinceComparator implements Comparator<Province>{
    @Override
    public int compare(Province p1, Province p2) {
        Collator trCollator = Collator.getInstance(new Locale("tr","TR"));
        return trCollator.compare(p1.getName(),p2.getName());
    }
}
