package ta3ik.linkreduction.model.mapper;

import linkreduction.model.LinkDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ta3ik.linkreduction.model.entity.Link;

@Mapper(componentModel = "spring")
public interface LinkMapper {

    LinkDTO toDTO(Link link);

    Link toEntity(LinkDTO linkDTO);
}
