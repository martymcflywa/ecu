include_guard(GLOBAL)

list(INSERT CMAKE_PREFIX_PATH 0 "${PROJECT_BINARY_DIR}/targets")
list(INSERT CMAKE_PREFIX_PATH 0 "${PROJECT_BINARY_DIR}/modules")
list(INSERT CMAKE_MODULE_PATH 0 "${PROJECT_BINARY_DIR}/targets")
list(INSERT CMAKE_MODULE_PATH 0 "${PROJECT_BINARY_DIR}/modules")

include(CMakeParseArguments)


## add_module(NAME       <name of module>
##           [DIRECTORY  <directory of module>]               # defaults to the given NAME
##           [TARGETS    <list of the targets of the module>] # defaults to the given NAME
## )
macro(add_module)
  cmake_parse_arguments(ADD_MODULE "" "NAME;DIRECTORY" "TARGETS" ${ARGN})
  if(NOT ADD_MODULE_DIRECTORY)
    set(ADD_MODULE_DIRECTORY "${ADD_MODULE_NAME}")
  endif()
  if(NOT ADD_MODULE_TARGETS)
    list(APPEND ADD_MODULE_TARGETS "${ADD_MODULE_NAME}")
  endif()

  add_subdirectory(${ADD_MODULE_DIRECTORY} ${ADD_MODULE_UNPARSED_ARGUMENTS})

  file(WRITE "${PROJECT_BINARY_DIR}/cmake/${ADD_MODULE_NAME}Config.cmake.in" "")
  foreach(_TARGET ${ADD_MODULE_TARGETS})
    export(TARGETS ${_TARGET} FILE "${PROJECT_BINARY_DIR}/targets/${ADD_MODULE_NAME}_${_TARGET}Targets.cmake" )

    file(APPEND "${PROJECT_BINARY_DIR}/cmake/Find${ADD_MODULE_NAME}.cmake.in" "
      if(NOT TARGET ${_TARGET})
        include(${PROJECT_BINARY_DIR}/targets/${ADD_MODULE_NAME}_${_TARGET}Targets.cmake )
      endif()
    ")

    configure_file(
    	"${PROJECT_BINARY_DIR}/cmake/${ADD_MODULE_NAME}Config.cmake.in"
    	"${PROJECT_BINARY_DIR}/modules/Find${ADD_MODULE_NAME}.cmake"
    )
  endforeach(_TARGET)
  unset(ADD_MODULE_DIRECTORY)
  unset(ADD_MODULE_TARGET)
  unset(ADD_MODULE_NAME)
endmacro(add_module)
