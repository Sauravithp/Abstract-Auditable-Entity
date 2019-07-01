# Spring Data JPA Auditing

### JPA and Hibernate provides Automatic Auditing which means tracking/logging date and auditor when we do any changes in our persisted records.

This project will walk us through to the necessary steps and code that we will need to include in our project to automatically  persist the CreatedBy, CreatedDate, LastModifiedBy, and LastModifiedDate columns for any entity.

## Annotation 
1.*@CreatedDate
2.*@CreatedBy 
3.*@LastModifiedDate
4.*@LastModifiedBy

To make JPA callbacks work in abstract approach these annotations are provided to automatically save and update auditing entities.

As our goal is tracking/logging date and author, we create a seperate abstract entity class with these annoatation and annotate this base class with @MappedSuperClass.Such that we can use the Auditable class in other entities.

We add a JPA entity listener class i.e AuditingEntityListener, which contains the callback methods which will be used to persist and update these properties when we  do any changes in our persisted records.

### @Data
### @MappedSuperclass
### @EntityListeners(AuditingEntityListener.class)
### public abstract class AbstractAuditableEntity<U,ID> extends AbstractPersistableEntity<ID>{
  
### @CreatedDate
### @Column(name = "created_date", updatable = false)
### LocalDate createdDate;

###    @LastModifiedDate
###    LocalDate lastModifiedDate;

###    @CreatedBy
###    @Column(name = "created_by",updatable = false)
###    U createdBy;

###    @LastModifiedBy
###    @Column(name = "last_modified_by")
###    U lastModifiedBy;
###   }


## Configuration

We enable JPA Auditing by using **@EnableJpaAuditing**.**@EnableJpaAuditing** accepts one argument auditorAwareRef where we need to pass the name of the AuditorAware bean.

Date can be scaned by the methods provided by **@EnableJpaAuditing** but when scanning for author Jpa uses currently logged user through the implementation of getCurrentAuditor provided by AudiotrAware.

### @Configuration
### @EnableJpaAuditing(auditorAwareRef = "auditorAware")
### public class JpaAuditingConfiguration {
###     @Bean
###   public AuditorAware<String> auditorAware(){
###        return new AuditAwareImpl();
###    }
### }

### public class AuditAwareImpl implements AuditorAware<String>{
###    @Override
###    public Optional<String> getCurrentAuditor() {
###        return Optional.ofNullable("sauravi");
###    }

 we can also use spring security, such that currently logged username can be obtained.
 
Replace: return Optional.ofNullable("sauravi");
With:    SecurityContextHolder.getContext().getAuthentication().getName()


