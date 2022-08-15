package com.AstravueEx.astravuetask.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.AstravueEx.astravuetask.Configure.WriteableRepository;
import com.AstravueEx.astravuetask.Enumeration.Priority;
import com.AstravueEx.astravuetask.Enumeration.Status;
import com.AstravueEx.astravuetask.entity.Astravue;

public interface AstravueRepository extends WriteableRepository<Astravue, Integer> {

	List<Astravue> findByStatus(Status status);

	List<Astravue> findByPriority(Priority priority);

	@Query(value = "SELECT a.id,a.due_date,a.name,a.start_date,a.priority,a.status FROM astravue.astravue a where a.due_date= :dueDate", nativeQuery = true)
	List<Astravue> findByDueDate(String dueDate);

	List<Astravue> findByDueDate(Astravue task);

}
