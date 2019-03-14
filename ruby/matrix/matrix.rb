class Matrix
  attr_reader :rows, :columns

  def initialize(matrix)
    @rows = create_rows(matrix)
    @columns = rows.transpose
  end

  private

  def create_rows(matrix)
    matrix.each_line.map { |row| row.split.map(&:to_i) }
  end
end
