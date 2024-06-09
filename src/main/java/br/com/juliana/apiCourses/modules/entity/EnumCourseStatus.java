package br.com.juliana.apiCourses.modules.entity;

public enum EnumCourseStatus {
  ACTIVE("Ativo"), 
  INACTIVE("Inativo");

  private final String status;

  private EnumCourseStatus(String status) {
    this.status = status;
  }

  public String geStatus() {
    return status;
  }
}
