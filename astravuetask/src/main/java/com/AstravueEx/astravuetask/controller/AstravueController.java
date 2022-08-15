package com.AstravueEx.astravuetask.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AstravueEx.astravuetask.Enumeration.Priority;
import com.AstravueEx.astravuetask.Enumeration.Status;
import com.AstravueEx.astravuetask.Service.AstravueService;
import com.AstravueEx.astravuetask.entity.Astravue;

@RestController
@RequestMapping("api/astravue")
public class AstravueController {

	@Autowired
	AstravueService astravueService;

	@PostMapping("/create")
	public String create(@RequestBody Astravue request) {

		Astravue astObject = new Astravue();
		astObject.setName(request.getName());
		astObject.setDueDate(request.getDueDate());
		astObject.setStartDate(request.getStartDate());
		astObject.setPriority(request.getPriority());
		astObject.setStatus(request.getStatus());
		astravueService.save(astObject);

		return "Created successfully";

	}

	@GetMapping("/get")
	public Iterable<Astravue> get() {
		return astravueService.findAll();
	}

	@PutMapping("/update")
	public Astravue update(@RequestBody Astravue request) {
		return astravueService.update(request);
	}

	@DeleteMapping("/delete/{Id}")
	public String deleteAstravue(@PathVariable("Id") Integer Id) {
		astravueService.deleteAstravue(Id);
		return "Deleted successfully";
	}

	@GetMapping("/get/{Id}")
	public Astravue getAstravue(@PathVariable("Id") Integer Id) {
		Optional<Astravue> task = astravueService.findById(Id);
		return task.get();
	}

	@GetMapping("/Status/{status}")
	public List<Astravue> getStatus(@PathVariable("status") Status status) {
		List<Astravue> statusList = astravueService.findByStatus(status);
		return statusList;
	}

	@GetMapping("/Priority/{priority}")
	public List<Astravue> getPriority(@PathVariable("priority") Priority priority) {
		List<Astravue> priorityList = astravueService.findByPriority(priority);
		return priorityList;
	}

	@GetMapping("/date/{dueDate}")
	public List<Astravue> getDueDate(@PathVariable("dueDate") String dueDate) {
		List<Astravue> dueDateList = astravueService.findByDueDate(dueDate);
		return dueDateList;
	}

}
