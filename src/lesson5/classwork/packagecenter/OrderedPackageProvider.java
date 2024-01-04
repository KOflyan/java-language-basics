package lesson5.classwork.packagecenter;

import java.util.ArrayList;
import java.util.List;

public class OrderedPackageProvider implements PackageProvider {
    private List<Package> packages = new ArrayList<>();
    private PackageFilter filter;

    public OrderedPackageProvider(PackageFilter filter) {
        this.filter = filter;
    }

    @Override
    public Package getNextPackage() {
        Package next = null;
        for (Package parcel : packages) {
            boolean isPremiumParcel = parcel instanceof PremiumPackage;
            boolean isPremiumNext = next instanceof PremiumPackage;
            if (next == null ||
                    isPremiumParcel &&!isPremiumNext ||
                    !isPremiumParcel && !isPremiumNext && next.getTotalPriority() < parcel.getTotalPriority() ||
                    isPremiumNext && isPremiumParcel &&
                    (((PremiumPackage) next).getPriority() < ((PremiumPackage) parcel).getPriority())) {
                next = parcel;
            }
        }
        if (next != null) packages.remove(next);
        return next;
    }

    @Override
    public void addPackage(Package packageToAdd) {
        if (filter.isValid(packageToAdd)) {
            packages.add(packageToAdd);
        }
    }

    @Override
    public boolean hasNextPackage() {
        return !packages.isEmpty();
    }

    @Override
    public PackageFilter getPackageFilter() {
        return filter;
    }

    @Override
    public void setPackageFilter(PackageFilter packageFilter) {
        if (packageFilter != null) {
            this.filter = packageFilter;
        }
    }

    @Override
    public List<Package> getPackages() {
        return packages;
    }

    private List<Package> findAllPackagesByCustomer(Customer customer, boolean isReciever) {
        List<Package> senderPackages = new ArrayList<>();
        if (!Customer.isValid(customer)) return senderPackages;

        for (Package parcel : packages) {
            Customer customerToCompareWith = isReciever ? parcel.receiver : parcel.sender;
            if (customerToCompareWith.equals(customer)) {
                senderPackages.add(parcel);
            }
        }
        return senderPackages;
    }

    @Override
    public List<Package> findAllPackagesBySender(Customer customer) {
        return findAllPackagesByCustomer(customer, false);
    }

    @Override
    public List<Package> findAllPackagesByReceiver(Customer customer) {
        return findAllPackagesByCustomer(customer, true);
    }
}
