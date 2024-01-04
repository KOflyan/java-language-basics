package lesson5.classwork.packagecenter;

public class OrderedPackageFilter implements PackageFilter{
    @Override
    public boolean isValid(Package p) {
        if (p != null && p.height > 0 && p.width > 0) {
            if (p instanceof PremiumPackage premium && premium.getPriority() <0 && premium.getPriority() > 1000)  {
                return false;
            }
            return Customer.isValid(p.receiver) && Customer.isValid(p.sender);
        }
        return false;
    }
}
