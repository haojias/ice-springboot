package xin.haojias.ice.common.log;

import org.springframework.data.jpa.repository.JpaRepository;


import java.io.Serializable;

public interface LogRepository  extends JpaRepository<LogEntity,Long>,Serializable {
}
