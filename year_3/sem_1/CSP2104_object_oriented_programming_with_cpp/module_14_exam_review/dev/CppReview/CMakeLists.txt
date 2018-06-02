cmake_minimum_required(VERSION 3.11)

list(INSERT CMAKE_MODULE_PATH 0 ${CMAKE_CURRENT_LIST_DIR}/cmake)
list(INSERT CMAKE_PREFIX_PATH 0 ${CMAKE_CURRENT_LIST_DIR}/cmake)

include(AddModule)
include(AddExternalModule)
include(SetupCatch2)

enable_testing()

add_module(NAME review)
add_module(NAME review_test)
add_module(NAME util)
add_module(NAME util_test)

add_module(NAME CppReview)

add_subdirectory(doc)
