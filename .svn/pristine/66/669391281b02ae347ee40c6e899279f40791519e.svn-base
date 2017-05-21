package gui;

import geography.*;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.text.NumberFormat;
import java.util.*;
import java.util.List;

public class Main {
    private static Country country;
    private static GeographyController controller;
    private static JFrame frame;
    private static JList<Region> regionJList;
    private static JList<Province> provinceJList = new JList<>();
    private static JList<Town> townJList = new JList<>();
    private static JLabel provinceInformation = new JLabel("");

    public static void main(String[] args) {
        parseCountry();
        createFrame();
        createRegionList();
        addListenerToRegionList();
        createProvinceAndTownList();
        addListenerToProvinceList();
        addBottomPanelToFrame(createBottomPanel());
    }

    private static void parseCountry() {
        country = JSONReader.parseCountryFrom("data" + File.separator + "turkey.json");
        controller = new GeographyController(country);
        try {
            assert country != null;
        }catch (Exception e){
            System.err.println("Can't parse country! Exiting");
            System.exit(20);
        }
    }

    private static void createFrame() {
        frame = new JFrame(country.getName());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(controller.getView(), BorderLayout.CENTER);
        frame.setSize(1000, 1000);
    }

    private static void createRegionList() {
        java.util.List<Region> regions = country.getRegions();
        regionJList = new JList<>(new Vector<>(regions));
        regionJList.setVisibleRowCount(20);
        regionJList.setCellRenderer(new DefaultListCellRenderer());
        regionJList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        frame.add(new JScrollPane(regionJList), BorderLayout.WEST);
    }

    private static void addListenerToRegionList() {
        regionJList.addListSelectionListener(listSelectionEvent -> {
            List<Province> provinces = new ArrayList<>();
            if(!listSelectionEvent.getValueIsAdjusting()){
                List<Region> selectedValues = regionJList.getSelectedValuesList();
                for (Region selectedValue : selectedValues) {
                    provinces.addAll(selectedValue.getProvinces());
                    provinceInformation.setText("");
                }
                provinceJList.setListData(provinces.toArray(new Province[provinces.size()]));
            }
        });
    }

    private static void createProvinceAndTownList() {
        provinceJList.setVisibleRowCount(20);
        provinceJList.setCellRenderer(new DefaultListCellRenderer());
        frame.add(new JScrollPane(provinceJList), BorderLayout.CENTER);
        townJList.setVisibleRowCount(20);
        townJList.setCellRenderer(new DefaultListCellRenderer());
        frame.add(new JScrollPane(townJList), BorderLayout.EAST);
    }

    private static void addListenerToProvinceList() {
        provinceJList.addListSelectionListener(listSelectionEventTown -> {
            List<Town> towns = new ArrayList<>();
            if (!listSelectionEventTown.getValueIsAdjusting()) {
                if(provinceJList.getSelectedValue() != null) {
                    Province selectedValue = provinceJList.getSelectedValue();
                    towns.addAll(selectedValue.getTowns());
                    provinceInformation.setText("<html>" + "Plate ID: " + selectedValue.getPlateID() + "<br/>" +
                            "Population: " + NumberFormat.getIntegerInstance().format(selectedValue.getPopulation())
                            + "</html>");
                    townJList.setListData(towns.toArray(new Town[towns.size()]));
                }else
                    townJList.setListData(new Town[0]);
            }
        });
    }


    private static JPanel createBottomPanel() {
        JPanel bottomPanel = new JPanel(new GridLayout(2,1));
        createProvinceInformationPanel(bottomPanel);
        createButtonPanel(bottomPanel);
        return bottomPanel;
    }

    private static void createProvinceInformationPanel(JPanel bottomPanel) {
        JPanel provinceInformationPanel = new JPanel();
        provinceInformationPanel.add(provinceInformation);
        bottomPanel.add(provinceInformationPanel);
    }

    private static void createButtonPanel(JPanel bottomPanel) {
        JPanel buttonPanel = new JPanel();
        JButton sortDescPopulation = new JButton("Sort by Population | Descending");
        JButton sortAscPopulation = new JButton("Sort by Population | Ascending");
        JButton sortDescName = new JButton("Sort by Name | Descending");
        JButton sortAscName = new JButton("Sort by Name | Ascending");
        addListenerToDescPopulation(sortDescPopulation);
        addListenerToAscPopulation(sortAscPopulation);
        addListenerToDescName(sortDescName);
        addListenerToAscName(sortAscName);
        buttonPanel.add(sortDescPopulation);
        buttonPanel.add(sortAscPopulation);
        buttonPanel.add(sortDescName);
        buttonPanel.add(sortAscName);
        bottomPanel.add(buttonPanel);
    }

    private static void addListenerToDescPopulation(JButton sortDescPopulation) {
        sortDescPopulation.addActionListener(actionEvent -> {
            List<Province> provinces = new ArrayList<>();
            for (Region region: regionJList.getSelectedValuesList()){
                provinces.addAll(region.getProvinces());
            }
            provinces.sort(Comparator.comparing(Province::getPopulation).reversed());
            provinceJList.setListData(provinces.toArray(new Province[provinces.size()]));
        });
    }

    private static void addListenerToAscPopulation(JButton sortAscPopulation) {
        sortAscPopulation.addActionListener(actionEvent -> {
            List<Province> provinces = new ArrayList<>();
            for (Region region: regionJList.getSelectedValuesList()){
                provinces.addAll(region.getProvinces());
            }
            provinces.sort(Comparator.comparing(Province::getPopulation));
            provinceJList.setListData(provinces.toArray(new Province[provinces.size()]));
        });
    }

    private static void addListenerToDescName(JButton sortDescName) {
        sortDescName.addActionListener(actionEvent -> {
            List<Province> provinces = new ArrayList<>();
            for (Region region: regionJList.getSelectedValuesList()){
                provinces.addAll(region.getProvinces());
            }
            provinces.sort(new ProvinceComparator().reversed());
            provinceJList.setListData(provinces.toArray(new Province[provinces.size()]));
        });
    }

    private static void addListenerToAscName(JButton sortAscName) {
        sortAscName.addActionListener(actionEvent -> {
            List<Province> provinces = new ArrayList<>();
            for (Region region: regionJList.getSelectedValuesList()){
                provinces.addAll(region.getProvinces());
            }
            provinces.sort(new ProvinceComparator());
            provinceJList.setListData(provinces.toArray(new Province[provinces.size()]));
        });
    }

    private static void addBottomPanelToFrame(JPanel bottomPanel) {
        frame.add(bottomPanel, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }

}
