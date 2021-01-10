package kg.andro.myrecycler;

public class RecyclerModel {
    private int delete_btn;
    private String num_recyclerview;

    public RecyclerModel(int delete_btn, String num_recyclerview) {
        this.delete_btn = delete_btn;
        this.num_recyclerview = num_recyclerview;
    }

    public int getDelete_btn() {
        return delete_btn;
    }

    public void setDelete_btn(int delete_btn) {
        this.delete_btn = delete_btn;
    }

    public String getNum_recyclerview() {
        return num_recyclerview;
    }

    public void setNum_recyclerview(String num_recyclerview) {
        this.num_recyclerview = num_recyclerview;
    }
}
