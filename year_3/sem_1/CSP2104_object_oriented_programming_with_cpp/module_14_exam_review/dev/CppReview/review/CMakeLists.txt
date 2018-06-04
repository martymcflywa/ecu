cmake_minimum_required(VERSION 3.11)
project(review LANGUAGES CXX)

find_package(util REQUIRED)

add_library(${PROJECT_NAME} 
  src/m5/IdValidator.cpp
  src/m5/SessionPlanner.cpp
  src/m5/Nested.cpp
  src/m5/ArrayOps.cpp
  src/m7/Functions.cpp
  src/m8/CollegeCourse.cpp
  src/m8/Letter.cpp
  src/m8/Employee.cpp
  src/m8/HrSystem.cpp
  src/m9/Pizza.cpp
  src/m9/Name.cpp
  src/m9/Credit.cpp
  src/m9/Customer.cpp
  src/m10/Employee.cpp
  src/m10/Worker.cpp
  src/m10/Manager.cpp
  src/m10/HrSystem.cpp
  src/m10/Mammal.cpp
  src/m10/Lion.cpp
  src/m10/Tiger.cpp
  src/m10/Liger.cpp
)

add_library(${PROJECT_NAME}::${PROJECT_NAME} ALIAS ${PROJECT_NAME})
target_compile_features(${PROJECT_NAME} PUBLIC cxx_std_17)

target_include_directories(${PROJECT_NAME}
  PUBLIC
    $<BUILD_INTERFACE:${CMAKE_BINARY_DIR}/include>
    $<BUILD_INTERFACE:${CMAKE_CURRENT_LIST_DIR}/include>
    $<INSTALL_INTERFACE:include>
)

target_link_libraries(${PROJECT_NAME}
  PRIVATE
    util::util
)

include(GenerateExportHeader)
generate_export_header(${PROJECT_NAME}
  EXPORT_FILE_NAME ${CMAKE_BINARY_DIR}/include/${PROJECT_NAME}/export.h
  EXPORT_MACRO_NAME REVIEW_API
)

include(GNUInstallDirs)

install(
    TARGETS  ${PROJECT_NAME}
    EXPORT   ${PROJECT_NAME}Config
    ARCHIVE  DESTINATION ${CMAKE_INSTALL_LIBDIR}
    LIBRARY  DESTINATION ${CMAKE_INSTALL_LIBDIR}
    INCLUDES DESTINATION ${CMAKE_INSTALL_INCLUDEDIR})

install(DIRECTORY include/${PROJECT_NAME} DESTINATION ${CMAKE_INSTALL_INCLUDEDIR})
install(DIRECTORY ${CMAKE_BINARY_DIR}/include/${PROJECT_NAME} DESTINATION ${CMAKE_INSTALL_INCLUDEDIR})
install(EXPORT ${PROJECT_NAME}Config DESTINATION ${CMAKE_INSTALL_LIBDIR}/cmake)
