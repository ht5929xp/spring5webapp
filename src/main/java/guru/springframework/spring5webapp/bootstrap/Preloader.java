package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Contractor;
import guru.springframework.spring5webapp.model.Home;
import guru.springframework.spring5webapp.model.Owner;
import guru.springframework.spring5webapp.repositories.ContractorRepository;
import guru.springframework.spring5webapp.repositories.HomeRepository;
import guru.springframework.spring5webapp.repositories.OwnerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Preloader implements CommandLineRunner {

    private final HomeRepository homeRepo;
    private final OwnerRepository ownerRepo;
    private final ContractorRepository contractorRepo;

    public Preloader(HomeRepository homeRepo, OwnerRepository ownerRepo, ContractorRepository contractorRepo) {
        this.homeRepo = homeRepo;
        this.ownerRepo = ownerRepo;
        this.contractorRepo = contractorRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started data preloader.");

        Home homeA = new Home(600, "test");
        Owner ownerA = new Owner("test", "test2");
        Owner ownerB = new Owner("test", "test3");

        Contractor contractorA = new Contractor("test", "test2", "testCity", "MI", 48323);

        homeA.setContractor(contractorA);
        homeA.getOwners().add(ownerA);
        ownerA.getHomes().add(homeA);

        contractorRepo.save(contractorA);
        ownerRepo.save(ownerA);
        ownerRepo.save(ownerB);
        homeRepo.save(homeA);

        long ownerCount = ownerRepo.count();
        long homeCount = homeRepo.count();
        long contractorCount = contractorRepo.count();

        System.out.println("Home count = " + homeCount);
        System.out.println("Owner count = " + ownerCount);
        System.out.println("Contractor count = " + contractorCount);

        homeRepo.findAll().forEach(h -> System.out.println(h));
        System.out.println("Completed data preloading.");
    }
}
