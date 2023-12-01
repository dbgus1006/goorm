import java.util.HashMap;

public class Cart {
    HashMap<String, Integer> myCart = new HashMap<>();

    void showItems() {
        for (String key : myCart.keySet()) {
            Integer value = myCart.get(key);
            System.out.println(key + ", " + value + "개");
        }
    }

    void addProduct(String key, int count) {

        if (myCart.containsKey(key)) {
            myCart.replace(key, myCart.get(key) + count);
            return;
        }
        myCart.put(key, count);
    }

    void removeProduct(String key, int count) {
        if (myCart.containsKey(key)) {
            myCart.replace(key, myCart.get(key) - count);
            if (myCart.get(key) == 0) {
                myCart.remove(key);
            }
            return;
        }

    }
}
