  # Emitting class Main {...}
    # Emitting void main(...) {...}
.LC0:
    .string "%d"
.LC1:
    .string "\n"
    .globl _main

_main:
    pushl %ebp
    movl %esp, %ebp
      # Emitting (...)
        # Emitting i1 = 1
          # Emitting 1
          movl $1, %edi
          # Emitting i1
          subl $4, %esp
        movl %edi, -4(%ebp)
        # Emitting i2 = 2
          # Emitting 2
          movl $2, %esi
          # Emitting i2
          subl $4, %esp
        movl %esi, -8(%ebp)
        # Emitting write(i1)
          # Emitting i1
          movl -4(%ebp), %edi
        pushl %edi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting writeln()
        pushl $.LC1
        call _printf
        addl $4, %esp
        # Emitting write(i2)
          # Emitting i2
          movl -8(%ebp), %edi
        pushl %edi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting writeln()
        pushl $.LC1
        call _printf
        addl $4, %esp
        # Emitting i0 = i1
          # Emitting i1
          movl -4(%ebp), %edi
          # Emitting i0
          subl $4, %esp
        movl %edi, -12(%ebp)
        # Emitting i1 = i2
          # Emitting i2
          movl -8(%ebp), %esi
          # Emitting i1
          movl -4(%ebp), %edi
        movl %esi, -4(%ebp)
        # Emitting i2 = i0
          # Emitting i0
          movl -12(%ebp), %edi
          # Emitting i2
          movl -8(%ebp), %esi
        movl %edi, -8(%ebp)
        # Emitting write(i1)
          # Emitting i1
          movl -4(%ebp), %esi
        pushl %esi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting writeln()
        pushl $.LC1
        call _printf
        addl $4, %esp
        # Emitting write(i2)
          # Emitting i2
          movl -8(%ebp), %esi
        pushl %esi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting writeln()
        pushl $.LC1
        call _printf
        addl $4, %esp
    movl %ebp, %esp
    movl $0, %eax
    popl %ebp
    ret
