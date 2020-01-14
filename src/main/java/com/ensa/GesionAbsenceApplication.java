package com.ensa;

import java.util.Arrays;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.context.ConfigurableWebApplicationContext;

import com.ensa.models.Role;
import com.ensa.models.Utilisateur;
import com.ensa.repositories.RoleRepository;
import com.ensa.repositories.UtilisateurRepository;


@SpringBootApplication
public class GesionAbsenceApplication {

    public static void main(String[] args) {
    	ConfigurableApplicationContext  ctx=SpringApplication.run(GesionAbsenceApplication.class, args);
    	/*RoleRepository repository = ctx.getBean(RoleRepository.class);
    	UtilisateurRepository userRepository = ctx.getBean(UtilisateurRepository.class);
    	Role roleUser = new Role("ROLE_USER");
    	Role roleAdmin = new Role("ROLE_ADMIN");
    	Utilisateur user = new Utilisateur("user","password",true);
    	user.setRoles(Arrays.asList(roleUser));

    	Utilisateur admin = new Utilisateur("admin","password1",true);
    	admin.setRoles(Arrays.asList(roleUser,roleAdmin));
    	
    	repository.save(roleUser);
    	repository.save(roleAdmin);
    	userRepository.save(user);
    	userRepository.save(admin);
    	/*RoleRepository repository = ctx.getBean(RoleRepository.class);
    	Role roleBureauOrdre = new Role("ROLE_BureauOrdre");
    	Role roleDirecteur = new Role("ROLE_Directeur");
    	repository.save(roleBureauOrdre);
    	repository.save(roleDirecteur);*/
    	//CourrierRepository courrierRepository = ctx.getBean(CourrierRepository.class);
    //	Courrier courrier = new CourrierArrive("courrier_arrivee", "fax", "probleme de facturation d'eau", new Date("22/7/1997"), new Date(12/07/1997),"http://fdsfs.ds","contenu");
    	//courrierRepository.save(courrier);
    }
}


