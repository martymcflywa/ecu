include_guard(GLOBAL)

include(CMakeParseArguments)
include(AddModule)
include(GitClone)

macro(add_external_module)
  cmake_parse_arguments(_ADD_EXT_MODULE "QUIET" "URL;BRANCH;CHECKOUT_DIR;DIRECTORY;NAME" "TARGETS" ${ARGN})
  if(NOT _ADD_EXT_MODULE_DIRECTORY)
    set(_ADD_EXT_MODULE_DIRECTORY "${_ADD_EXT_MODULE_CHECKOUT_DIR}")
  endif()

  if(_ADD_EXT_MODULE_QUIET)
    list(APPEND _ADD_EXT_MODULE_GIT_CLONE_ADDITIONAL_ARGS
         QUIET)
  endif()

  if(_ADD_EXT_MODULE_BRANCH)
    list(APPEND _ADD_EXT_MODULE_GIT_CLONE_ADDITIONAL_ARGS
         BRANCH ${_ADD_EXT_MODULE_BRANCH})
  endif()

  git_clone(
    URL "${_ADD_EXT_MODULE_URL}"
    CHECKOUT_DIR "${_ADD_EXT_MODULE_CHECKOUT_DIR}"
    ${_ADD_EXT_MODULE_GIT_CLONE_ADDITIONAL_ARGS}
  )

  add_module(
    NAME "${_ADD_EXT_MODULE_NAME}"
    DIRECTORY "${_ADD_EXT_MODULE_DIRECTORY}"
    TARGETS ${_ADD_EXT_MODULE_TARGETS}
    ${_ADD_EXT_MODULE_UNPARSED_ARGUMENTS}
  )

endmacro(add_external_module)
