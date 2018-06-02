include_guard(GLOBAL)

set(ENABLE_INSTALL ON)

macro(install)
	if(${ENABLE_INSTALL})
		_install(${ARGV})
	endif()
endmacro(install)
