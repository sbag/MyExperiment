package com.bharaththippireddy.trainings.jaxrs;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.bharathippireddy.trainings.jaxrs.exceptions.SomeBusinessException;

public class PatientServiceImpl implements PatientService {
	long currentId = 123;
	Map<Long, Patient> patients = new HashMap<Long, Patient>();
	Map<Long, Prescription> prescriptions = new HashMap<Long, Prescription>();

	public PatientServiceImpl() {
		init();
	}

	final void init() {
		Patient patient = new Patient();
		patient.setName("John");
		patient.setId(123);
		patients.put(patient.getId(), patient);

		Prescription prescription = new Prescription();
		prescription.setDescription("prescription 223");
		prescription.setId(223);
		prescriptions.put(prescription.getId(), prescription);
	}

	public Response addPatient(Patient patient) {
		System.out.println("----invoking addPatient, Patient name is: "
				+ patient.getName());
		patient.setId(++currentId);

		patients.put(patient.getId(), patient);

		return Response.ok(patient).build();
	}

	public Patient getPatient(String id) {
		System.out.println("----invoking getPatient, Patient id is: " + id);
		long idNumber = Long.parseLong(id);
		Patient patient = patients.get(idNumber);

		if (patient == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}

		return patient;
	}

	public Response updatePatient(Patient updatedPatient) {
		System.out
				.println("----invoking updatePatient, updatePatient name is: "
						+ updatedPatient.getName());
		Patient currentPatient = patients.get(updatedPatient.getId());
		Response response;
		if (currentPatient != null) {
			patients.put(updatedPatient.getId(), updatedPatient);
			response = Response.ok().build();
		} else {
			// How it was earlier- response = Response.notModified().build();
			// Below is the new way using a JAX-RS Exception
			throw new NotFoundException();
		}

		return response;
	}

	public Response deletePatients(String id) {
		System.out.println("----invoking deletePatients, Patient id is: " + id);
		long idNumber = Long.parseLong(id);
		Patient patient = patients.get(idNumber);

		Response response;
		if (patient != null) {
			response = Response.ok().build();
			patients.remove(idNumber);
		} else {
			throw new SomeBusinessException("Business Exception");
		}

		return response;
	}

	public Prescription getPrescription(String prescriptionId) {
		System.out.println("----invoking getPrescription, Prescription id is: "
				+ prescriptionId);
		long idNumber = Long.parseLong(prescriptionId);
		Prescription prescription = prescriptions.get(idNumber);
		return prescription;
	}

}
