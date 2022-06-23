package model.MRAForm.Cost;

import com.google.gson.Gson;
import com.opencsv.bean.CsvBindByName;
import constants.Constants;

import java.util.ArrayList;
import java.util.List;

public class CostDetail {
    List<ThirdPartyCostDetail> thirdPartyCostDetailList = new ArrayList<>();
    List<OfficeSpaceRentalDetail> officeSpaceRentalList = new ArrayList<>();
    List<SalaryDetail> salaryDetailList = new ArrayList<>();

    @CsvBindByName
    String thirdPartyCostDetailIdList;
    @CsvBindByName
    String officeSpaceRentalIdList;
    @CsvBindByName
    String salaryDetailIdList;

    public List<ThirdPartyCostDetail> getThirdPartyCostDetailList() {
        return thirdPartyCostDetailList;
    }

    public void setThirdPartyCostDetailList(List<ThirdPartyCostDetail> thirdPartyCostDetailList) {
        this.thirdPartyCostDetailList = thirdPartyCostDetailList;
    }

    public List<OfficeSpaceRentalDetail> getOfficeSpaceRentalList() {
        return officeSpaceRentalList;
    }

    public void setOfficeSpaceRentalList(List<OfficeSpaceRentalDetail> officeSpaceRentalList) {
        this.officeSpaceRentalList = officeSpaceRentalList;
    }

    public List<SalaryDetail> getSalaryDetailList() {
        return salaryDetailList;
    }

    public void setSalaryDetailList(List<SalaryDetail> salaryDetailList) {
        this.salaryDetailList = salaryDetailList;
    }

    public String getThirdPartyCostDetailIdList() {
        return thirdPartyCostDetailIdList;
    }

    public void setThirdPartyCostDetailIdList(String thirdPartyCostDetailIdList) {
        this.thirdPartyCostDetailIdList = thirdPartyCostDetailIdList;
    }

    public String getOfficeSpaceRentalIdList() {
        return officeSpaceRentalIdList;
    }

    public void setOfficeSpaceRentalIdList(String officeSpaceRentalIdList) {
        this.officeSpaceRentalIdList = officeSpaceRentalIdList;
    }

    public String getSalaryDetailIdList() {
        return salaryDetailIdList;
    }

    public void setSalaryDetailIdList(String salaryDetailIdList) {
        this.salaryDetailIdList = salaryDetailIdList;
    }

    public void setThirdPartyCostDetailFromAllList(List<ThirdPartyCostDetail> thirdPartyCostDetailFromAllList){
        List<Integer> listOfId = convertStringListToInt(getThirdPartyCostDetailIdList());
        for(int id: listOfId){
            this.thirdPartyCostDetailList.add(thirdPartyCostDetailFromAllList.get(id));
        }

    }
    public void setOfficeSpaceRentalFromAllList(List<OfficeSpaceRentalDetail> officeSpaceRentalFromAllList){
        List<Integer> listOfId = convertStringListToInt(getOfficeSpaceRentalIdList());
        for(int id: listOfId){
            this.officeSpaceRentalList.add(officeSpaceRentalFromAllList.get(id));
        }
    }
    public void setSalaryDetailFromAllList(List<SalaryDetail> salaryDetailFromAllList){
        List<Integer> listOfId = convertStringListToInt(getSalaryDetailIdList());
        for(int id: listOfId){
            this.salaryDetailList.add(salaryDetailFromAllList.get(id));
        }
    }

    public List<Integer> convertStringListToInt(String unparsedString){
        List<String> stringList = List.of(unparsedString.split(Constants.LIST_OF_STRING_DELIMITER));
        Gson gson = new Gson();
        System.out.println(stringList);
        List<Integer> integers = new ArrayList<>();
        for(String str : stringList){
            int i = Integer.parseInt(str);
            integers.add(i);
        }
        return integers;
    }

    public CostDetail() {
    }

    public CostDetail(String thirdPartyCostDetailIdList, String officeSpaceRentalIdList, String salaryDetailIdList) {
        this.thirdPartyCostDetailIdList = thirdPartyCostDetailIdList;
        this.officeSpaceRentalIdList = officeSpaceRentalIdList;
        this.salaryDetailIdList = salaryDetailIdList;
    }
}
