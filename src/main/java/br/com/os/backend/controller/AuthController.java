package br.com.os.backend.controller;

import br.com.os.backend.dto.AuthRequestDTO;
import br.com.os.backend.dto.AuthResponseDTO;
import br.com.os.backend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    @Autowired
    private AuthService service;

    @PostMapping("/login")
    public AuthResponseDTO login(@RequestBody AuthRequestDTO dto) {
        return service.login(dto);
    }
}
