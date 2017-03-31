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
        # Emitting i3 = 3
          # Emitting 3
          movl $3, %edi
          # Emitting i3
          subl $4, %esp
        movl %edi, -12(%ebp)
        # Emitting i4 = 4
          # Emitting 4
          movl $4, %esi
          # Emitting i4
          subl $4, %esp
        movl %esi, -16(%ebp)
        # Emitting write((i1 / i2))
          # Emitting (i1 / i2)
            # Emitting i1
            movl -4(%ebp), %edi
            # Emitting i2
            movl -8(%ebp), %esi
          movl %edi, %eax
          cltd
          idivl %esi
          movl %eax, %edi
        pushl %edi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting write(((i1 / i2) / i3))
          # Emitting ((i1 / i2) / i3)
            # Emitting (i1 / i2)
              # Emitting i1
              movl -4(%ebp), %edi
              # Emitting i2
              movl -8(%ebp), %esi
            movl %edi, %eax
            cltd
            idivl %esi
            movl %eax, %edi
            # Emitting i3
            movl -12(%ebp), %esi
          movl %edi, %eax
          cltd
          idivl %esi
          movl %eax, %edi
        pushl %edi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting write((((i1 / i2) / i3) / i4))
          # Emitting (((i1 / i2) / i3) / i4)
            # Emitting ((i1 / i2) / i3)
              # Emitting (i1 / i2)
                # Emitting i1
                movl -4(%ebp), %edi
                # Emitting i2
                movl -8(%ebp), %esi
              movl %edi, %eax
              cltd
              idivl %esi
              movl %eax, %edi
              # Emitting i3
              movl -12(%ebp), %esi
            movl %edi, %eax
            cltd
            idivl %esi
            movl %eax, %edi
            # Emitting i4
            movl -16(%ebp), %esi
          movl %edi, %eax
          cltd
          idivl %esi
          movl %eax, %edi
        pushl %edi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting write((i1 / (i2 + i3)))
          # Emitting (i1 / (i2 + i3))
            # Emitting (i2 + i3)
              # Emitting i2
              movl -8(%ebp), %edi
              # Emitting i3
              movl -12(%ebp), %esi
            addl %esi, %edi
            # Emitting i1
            movl -4(%ebp), %esi
          movl %esi, %eax
          cltd
          idivl %edi
          movl %eax, %esi
        pushl %esi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting write((i1 / (i1 + i2)))
          # Emitting (i1 / (i1 + i2))
            # Emitting (i1 + i2)
              # Emitting i1
              movl -4(%ebp), %esi
              # Emitting i2
              movl -8(%ebp), %edi
            addl %edi, %esi
            # Emitting i1
            movl -4(%ebp), %edi
          movl %edi, %eax
          cltd
          idivl %esi
          movl %eax, %edi
        pushl %edi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting write((i1 / (i1 + 5)))
          # Emitting (i1 / (i1 + 5))
            # Emitting (i1 + 5)
              # Emitting i1
              movl -4(%ebp), %edi
              # Emitting 5
              movl $5, %esi
            addl %esi, %edi
            # Emitting i1
            movl -4(%ebp), %esi
          movl %esi, %eax
          cltd
          idivl %edi
          movl %eax, %esi
        pushl %esi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting write((10 / 20))
          # Emitting (10 / 20)
            # Emitting 10
            movl $10, %esi
            # Emitting 20
            movl $20, %edi
          movl %esi, %eax
          cltd
          idivl %edi
          movl %eax, %esi
        pushl %esi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting write((20 / 10))
          # Emitting (20 / 10)
            # Emitting 20
            movl $20, %esi
            # Emitting 10
            movl $10, %edi
          movl %esi, %eax
          cltd
          idivl %edi
          movl %eax, %esi
        pushl %esi
        pushl $.LC0
        call _printf
        addl $8, %esp
    movl %ebp, %esp
    movl $0, %eax
    popl %ebp
    ret
