public class testing {

    public static void main(String[] args) {
        int arr[] = {'H', 'e', 'l', 'l', 'o'};
        int key[] = {'f', 'o', 'o'};
        for (int i = 0; i < arr.length; ++i) {
            int traverseKey = i % 3;
            arr[i] = arr[i] ^ key[traverseKey];
        }
        System.out.println(arr);

        System.out.println('H' ^ 'f');
    }
}