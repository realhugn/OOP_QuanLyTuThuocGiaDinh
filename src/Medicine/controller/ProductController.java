package Medicine.controller;

import Medicine.Product;
import Medicine.Thuoc;

import java.util.ArrayList;
import java.util.Date;

public class ProductController {
    ArrayList<Product> list;

    public ProductController(ArrayList<Product> list) {
        this.list = list;
    }

    public void addMedicine(int id, String name, int quantỉty, String link, String unit, Date date, String effect){
        Thuoc MedToAdd = new Thuoc(id,name,quantỉty,link,unit,date,effect);
        list.add(MedToAdd);
    }
    public void removeMedicine(int removeProID ){
        list.removeIf(x -> x.getProductID() == removeProID);
    }
    public void edit (int option, int productID, String value){
        if (option == 1){
            editName(productID,value);
        } else if(option == 3){
            editLink(productID,value);
        } else if(option == 4){
            editUnit(productID,value);
        } else if(option == 2){
            editQuantity(productID,Integer.parseInt(value));
        }
    }
    public void edit(int option, int productID , Date date){
        if(option ==5){
            editExpiredDate(productID,date);
        }
    }
    public void editName(int productID,String name){
        findMedicineByID(productID).setName(name);
    }
    public void editQuantity(int productID, int quantity){
        findMedicineByID(productID).setQuantity(quantity);
    }
    public void editLink(int productID, String link){
        findMedicineByID(productID).setLink(link);
    }
    public void editUnit(int productID, String unit){
        findMedicineByID(productID).setUnit(unit);
    }

    public void editExpiredDate(int productID, Date date){
        Thuoc thuoc = (Thuoc)findMedicineByID(productID);
        thuoc.setExpiredDate(date);
    }
    public Product findMedicineByID(int productID){
        for (Product product : list) {
            if (product.getProductID() == productID) {
                return product;
            }
        }
        return null;
    }
}
