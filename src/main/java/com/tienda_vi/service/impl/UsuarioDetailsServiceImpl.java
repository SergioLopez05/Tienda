package com.tienda_vi.service.impl;

import com.tienda_vi.dao.UsuarioDao;
import com.tienda_vi.domain.Rol;
import com.tienda_vi.domain.Usuario;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class UsuarioDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioDao usuarioDao;
    
   @Autowired
private HttpSession session;


    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioDao.findByUsername(username);
        if (usuario == null) {  //No se encontró
            throw new UsernameNotFoundException(username);
        }
        //acceso a la imagen
        session.removeAttribute("imagenUsuario");
        session.setAttribute("imagenUsuario",usuario.getRutaImagen());

        var roles = new ArrayList<GrantedAuthority>();
        
        for (Rol r: usuario.getRoles()){
            roles.add(new SimpleGrantedAuthority(r.getNombre()));
        }
        return new User(usuario.getUsername(),usuario.getPassword(),roles);
    }

}
