import java.util.*;

public class CartApp {
    public static void main(String[] args) {
        Set<Product> productSet = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        int key = 1;

        while (true) {
            System.out.println("추가할 상품 이름과 가격을 입력하세요(입력을 끝내시려면 0을 입력하세요): ");
            String[] addProductInput = sc.nextLine().split(" ");

            if (addProductInput[0].equals("0")) {
                break;
            }
            productSet.add(new Product(key++, addProductInput[0], Integer.parseInt(addProductInput[1])));

        }

        System.out.println("고유한 상품 목록:");
        for (Product product : productSet) {
            System.out.println(product.getName() + " : " + product.getPrice());
        }

        Cart myCart = new Cart();

        while (true) {
            System.out.println("원하시는 메뉴를 선택하세요.");
            System.out.println("1. 장바구니 확인  2. 장바구니 추가  3. 장바구니 삭제  0. 종료");
            int selectMenu = Integer.parseInt(sc.nextLine());

            if (selectMenu == 1) {
                myCart.showItems();
            }
            if (selectMenu == 2) {
                for (Product product : productSet) {
                    System.out.println(product.getName() + " : " + product.getPrice());
                }
                System.out.println("장바구니에 담을 상품의 이름과 개수를 입력하세요.");
                String[] addCartInput = sc.nextLine().split(" ");
                myCart.addProduct(addCartInput[0], Integer.parseInt(addCartInput[1]));
            }
            if (selectMenu == 3) {
                System.out.println("장바구니에서 삭제할 상품의 이름과 개수를 입력하세요.");
                String[] addCartInput = sc.nextLine().split(" ");
                myCart.removeProduct(addCartInput[0], Integer.parseInt(addCartInput[1]));
            }
            if (selectMenu == 0) {
                break;
            }
        }
    }
}
