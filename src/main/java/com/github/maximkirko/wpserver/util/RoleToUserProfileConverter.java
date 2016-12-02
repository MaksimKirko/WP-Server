package com.github.maximkirko.wpserver.util;


import com.github.maximkirko.wpserver.datamodel.Role;
import com.github.maximkirko.wpserver.service.api.IRoleService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class RoleToUserProfileConverter implements Converter<Object, Role> {

    @Inject
    private IRoleService roleService;

    /*
     * Gets Role by Id
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    public Role convert(Object element) {
        Long id = Long.parseLong((String) element);
        Role role = roleService.getById(id);
        System.out.println("Role : " + role);
        return role;
    }

	/*
	 * Gets Role by type
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
	 */
	/*
	public Role convert(Object element) {
		String type = (String)element;
		Role profile= IRoleService.getByType(type);
		System.out.println("Profile ... : "+profile);
		return profile;
	}
	*/

}