package com.example.demolistview.services;

import com.example.demolistview.repositories.PersonFileRepository;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonService {
    PersonFileRepository repo = new PersonFileRepository();

    public List<String> loadDataForListView() throws IOException {
        List<String> lines = repo.readAllLines();
        List<String> result = new ArrayList<>();

        for (String line : lines) {
            if (line == null || line.isBlank()) {
                continue;
            }
            String[] parts = line.split(",");
            
            // Validación de seguridad: si la línea no tiene 3 partes, la saltamos
            if (parts.length < 3) {
                continue; 
            }

            String name = parts[0];
            String email = parts[1];
            String age = parts[2];
            result.add(name + " - " + email + " - " + age);
        }
        return result;
    }

    private List<String> getCleanLines() throws IOException {
        List<String> lines = repo.readAllLines();
        List<String> cleanLines = new ArrayList<>();
        for (String line : lines) {
            if (line != null && !line.isBlank()) {
                cleanLines.add(line);
            }
        }
        return cleanLines;
    }

    public void updatePerson(int index, String name, String email, int edad) throws IOException {
        validate(name, email, edad);
        List<String> data = getCleanLines();
        if (index < 0 || index >= data.size()) {
            throw new IllegalArgumentException("El indice es invalido");
        }
        data.set(index, name + "," + email + "," + edad);
        repo.saveFile(data);
    }

    public void addPerson(String name, String email, int age) throws IOException {
        validate(name, email, age);
        // CORRECCIÓN: Se agregó ", + age" para que el archivo tenga las 3 columnas
        repo.appendNewLine(name + "," + email + "," + age);
    }

    public void removePerson(int index) throws IOException {
        List<String> data = getCleanLines();
        if (index < 0 || index >= data.size()) {
            throw new IllegalArgumentException("El indice esta fuera de rango");
        }
        data.remove(index);
        repo.saveFile(data);
    }

    private void validate(String name, String email, int age) {
        if (name == null || name.isBlank() || name.length() < 3) {
            throw new IllegalArgumentException("El nombre es incorrecto (mínimo 3 caracteres)");
        }
        String em = (email == null) ? "" : email.trim();
        if (em.isBlank() || !em.contains("@") || !em.contains(".")) {
            throw new IllegalArgumentException("Formato de email incorrecto");
        }
        if (age < 0) {
            throw new IllegalArgumentException("La edad no puede ser negativa");
        }
        if (age < 18) {
            throw new IllegalArgumentException("Solo se aceptan mayores de edad (18+)");
        }
    }
}