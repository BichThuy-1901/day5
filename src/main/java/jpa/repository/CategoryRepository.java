package jpa.repository;

import jpa.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface CategoryRepository extends CrudRepository<CategoryEntity,Integer> {
}
