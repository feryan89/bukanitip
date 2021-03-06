package dietbisabesok.com.bukanitip.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ibnumuzzakkir on 26/05/2017.
 * Android Developer
 * Garena Indonesia
 */

public class SectionSecondDataModel {
    private String headerTitle;
    private List<CountryData> allItemsInSection;


    public SectionSecondDataModel() {

    }
    public SectionSecondDataModel(String headerTitle, ArrayList<CountryData> allItemsInSection) {
        this.headerTitle = headerTitle;
        this.allItemsInSection = allItemsInSection;
    }



    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    public List<CountryData> getAllItemsInSection() {
        return allItemsInSection;
    }

    public void setAllItemsInSection(List<CountryData> allItemsInSection) {
        this.allItemsInSection = allItemsInSection;
    }

}
