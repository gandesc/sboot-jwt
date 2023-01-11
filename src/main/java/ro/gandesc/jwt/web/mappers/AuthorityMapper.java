package ro.gandesc.jwt.web.mappers;

import org.mapstruct.Mapper;
import ro.gandesc.jwt.domain.security.Authority;
import ro.gandesc.jwt.web.models.AuthorityDto;

@Mapper
public interface AuthorityMapper {
    AuthorityDto roleToAuthorityDto(Authority entity);

    Authority roleDtoToAuthority(AuthorityDto dto);
}
