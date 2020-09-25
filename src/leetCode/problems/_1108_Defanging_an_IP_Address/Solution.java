package leetCode.problems._1108_Defanging_an_IP_Address;

public class Solution {
    public String defangIPaddr(String address) {
        return address.replaceAll("\\.", "[.]");
    }
}
