package lesson5.classwork.packagecenter;

import java.util.List;

/**
 * Package provider interface.
 */
public interface PackageProvider {

    /**
     * Returns whether the provider has next package or not.
     *
     * @return next package exists
     */
    Package getNextPackage();

    /**
     * Add the package to the list.
     * @param packageToAdd package
     */
    void addPackage(Package packageToAdd);

    /**
     * Returns whether the provider has next package or not.
     *
     * @return next package exists
     */
    boolean hasNextPackage();

    /**
     * Set package filter.
     * @param packageFilter pf
     */
    void setPackageFilter(PackageFilter packageFilter);

    /**
     * Get package filter.
     *
     * @return packageFilter
     */
    PackageFilter getPackageFilter();

    /**
     * Returns the list of all packages.
     *
     * @return all packages
     */
    List<Package> getPackages();

    /**
     * Returns whether the provider has next package or not.
     * @param customer sender
     * @return next package exists
     */
    List<Package> findAllPackagesBySender(Customer customer);

    /**
     * Returns whether the provider has next package or not.
     * @param customer receiver
     * @return next package exists
     */
    List<Package> findAllPackagesByReceiver(Customer customer);
}
