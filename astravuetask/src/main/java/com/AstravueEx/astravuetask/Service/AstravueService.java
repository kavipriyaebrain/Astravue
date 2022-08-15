package com.AstravueEx.astravuetask.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AstravueEx.astravuetask.Enumeration.Priority;
import com.AstravueEx.astravuetask.Enumeration.Status;
import com.AstravueEx.astravuetask.Repository.AstravueRepository;
import com.AstravueEx.astravuetask.entity.Astravue;

@Service
@Transactional

public class AstravueService {

	@Autowired
	AstravueRepository astravueRepository;

	public void save(Astravue obj) {
		astravueRepository.save(obj);
	}

	public Iterable<Astravue> findAll() {
		return astravueRepository.findAll();
	}

	public Astravue update(Astravue obj) {
		return astravueRepository.save(obj);
	}

	public void deleteAstravue(Integer Id) {
		astravueRepository.deleteById(Id);
	}

	public Optional<Astravue> findById(Integer Id) {
		return astravueRepository.findById(Id);
	}

	public List<Astravue> findByStatus(Status status) {

		return astravueRepository.findByStatus(status);
	}

	public List<Astravue> findByPriority(Priority priority) {
		return astravueRepository.findByPriority(priority);
	}

	public List<Astravue> findByDueDate(String dueDate) {
		return astravueRepository.findByDueDate(dueDate);
	}

	public List<Astravue> findByDueDate(Astravue astravue) {
		return astravueRepository.findByDueDate(astravue);
	}

}
